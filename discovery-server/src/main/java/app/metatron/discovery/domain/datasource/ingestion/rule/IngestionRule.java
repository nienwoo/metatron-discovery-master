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

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = DiscardNullRule.class, name = "discard"),
    @JsonSubTypes.Type(value = ReplaceNullRule.class, name = "replace"),
    @JsonSubTypes.Type(value = GeoPointRule.class, name = "geo_point"),
    @JsonSubTypes.Type(value = UserDefinedRule.class, name = "user_defined"),
    @JsonSubTypes.Type(value = ExclusionRule.class, name = "exclusion")
})
public interface IngestionRule extends Serializable {
}
