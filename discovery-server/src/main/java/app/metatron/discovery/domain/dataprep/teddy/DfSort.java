/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.metatron.discovery.domain.dataprep.teddy;

import app.metatron.discovery.domain.dataprep.teddy.exceptions.InvalidColumnExpressionTypeException;
import app.metatron.discovery.domain.dataprep.teddy.exceptions.TeddyException;
import app.metatron.discovery.prep.parser.preparation.rule.Rule;
import app.metatron.discovery.prep.parser.preparation.rule.Sort;
import app.metatron.discovery.prep.parser.preparation.rule.expr.Constant;
import app.metatron.discovery.prep.parser.preparation.rule.expr.Expression;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DfSort extends DataFrame {

  private static Logger LOGGER = LoggerFactory.getLogger(DfSort.class);

  public DfSort(String dsName, String ruleString) {
    super(dsName, ruleString);
  }

  @Override
  public List<Object> prepare(DataFrame prevDf, Rule rule, List<DataFrame> slaveDfs) throws TeddyException {
    List<Object> preparedArgs = new ArrayList<>();
    Sort sort = (Sort) rule;

    Expression orderByColExpr = sort.getOrder();
    Expression typeExpr = sort.getType();
    SortType sortType = SortType.ASCENDING;

    // order by expression -> order by colnames
    List<String> orderByColNames = TeddyUtil.getIdentifierList(orderByColExpr);
    if (orderByColNames.isEmpty()) {
      throw new InvalidColumnExpressionTypeException("doSort(): invalid order by column expression: " + sort);
    }
    interestedColNames.addAll(orderByColNames);

    // type절이 "DESC" 일 때는 내림차순. 기본은 오름차순.
    if (typeExpr != null) {
      if (typeExpr instanceof Constant.StringExpr) {
        if (((Constant.StringExpr) typeExpr).getEscapedValue().equalsIgnoreCase("DESC")) {
          sortType = SortType.DESCENDING;
        }
      } else {
        throw new InvalidColumnExpressionTypeException("doSort(): invalid sort type: " + sort);
      }
    }

    preparedArgs.add(orderByColNames);
    preparedArgs.add(sortType);
    return preparedArgs;
  }

  @Override
  public List<Row> gather(DataFrame prevDf, List<Object> preparedArgs, int offset, int length, int limit)
          throws InterruptedException, TeddyException {
    List<String> orderByColNames = (List<String>) preparedArgs.get(0);
    SortType sortType = (SortType) preparedArgs.get(1);

    sorted(prevDf, orderByColNames, sortType);

    return null;  // no more extra works needed
  }
}
