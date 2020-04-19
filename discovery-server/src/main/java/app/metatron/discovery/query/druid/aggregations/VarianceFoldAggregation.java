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

package app.metatron.discovery.query.druid.aggregations;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.validation.constraints.NotNull;

import app.metatron.discovery.query.druid.Aggregation;

/**
 * Created by hsp on 2016. 7. 19..
 */

@JsonTypeName("varianceFold")
public class VarianceFoldAggregation implements Aggregation {
  @NotNull
  String name;

  String fieldName;


  public VarianceFoldAggregation(@NotNull String name, @NotNull String fieldName) {
    this.name = name;
    this.fieldName = fieldName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }


  @Override
  public String toString() {
    return "VarianceFoldAggregation{" +
            "name='" + name + '\'' +
            ", fieldName='" + fieldName + '\'' +
            '}';
  }

}
