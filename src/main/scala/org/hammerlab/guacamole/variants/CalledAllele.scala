/**
 * Licensed to Big Data Genomics (BDG) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The BDG licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hammerlab.guacamole.variants

import org.hammerlab.guacamole.reference.ContigName
import org.hammerlab.guacamole.reference.Locus

/**
 *
 * A variant that exists in the sample; includes supporting read statistics
 *
 * @param sampleName sample the variant was called on
 * @param contigName chromosome or genome contig of the variant
 * @param start start position of the variant (0-based)
 * @param allele allele (ref + seq bases) for this variant
 * @param evidence supporting statistics for the variant
 * @param length length of the variant
 */
case class CalledAllele(sampleName: String,
                        contigName: ContigName,
                        start: Locus,
                        allele: Allele,
                        evidence: AlleleEvidence,
                        rsID: Option[Int] = None,
                        length: Int = 1) extends ReferenceVariant {
  val end: Locus = start + 1L
}
