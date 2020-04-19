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

package app.metatron.discovery.domain.engine;

import app.metatron.discovery.domain.datasource.data.CandidateQueryRequest;
import app.metatron.discovery.domain.datasource.data.CovarianceQueryRequest;
import app.metatron.discovery.domain.datasource.data.SearchQueryRequest;
import app.metatron.discovery.domain.datasource.data.SummaryQueryRequest;

/**
 * Created by kyungtaak on 2016. 9. 22..
 */
public interface QueryService {

  Object preview(SearchQueryRequest request);

  Object search(SearchQueryRequest request);

  Object candidate(CandidateQueryRequest request);

  Object summary(SummaryQueryRequest request);

  Object covariance(CovarianceQueryRequest request);

}
