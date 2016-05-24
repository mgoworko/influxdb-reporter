/*
 * Copyright 2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package influxdbreporter.core.metrics.pull

import influxdbreporter.core.metrics.{MetricByTag, Metric}
import influxdbreporter.core.metrics.Metric.CodahaleMetric
import influxdbreporter.core.metrics.MetricByTag.MetricByTags

import scala.concurrent.{ExecutionContext, Future}

class PullingCodehaleMetric[T <: CodahaleMetric](underlying: T) extends Metric[T] {

  override def popMetrics(implicit ec: ExecutionContext): Future[MetricByTags[T]] = {
    Future.successful(List(MetricByTag(List.empty, underlying)))
  }

}