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

package app.metatron.discovery.domain.datasource.ingestion.rule;

import com.fasterxml.jackson.annotation.JsonTypeName;

import app.metatron.discovery.spec.druid.ingestion.Validation;

@JsonTypeName("discard")
public class DiscardNullRule extends ValidationRule implements IngestionRule {

  public DiscardNullRule() {
  }

  @Override
  public Validation toValidation(String name) {
    StringBuilder sb = new StringBuilder();
    sb.append("\"").append(name).append("\"")
      .append(" == ").append("null");

    return new Validation(name, sb.toString());
  }
}
