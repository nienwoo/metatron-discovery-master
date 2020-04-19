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

import { UIOption } from '../ui-option';
import {
  AnnotationPosition, FontSize,
  GridViewType, Operator, UIFontStyle, UIOrient, UIPosition
} from '../define/common';
/**
 * 폭포차트 화면 UI에 필요한 옵션
 * Version 2.0
 */
export interface UIWaterfallChart extends UIOption {

  ////////////////////////////////////////////
  // 서버 스펙
  ////////////////////////////////////////////

  // 양수 / 음수 색상
  barColor?: BarColor;

  // 막대크기
  barSize?: number;
}

/**
 * 폭포차트 양수 / 음수 색상
 */
export interface BarColor {

  // 음수 색상
  negative?: string;

  // 양수 색상
  positive?: string;
}
