package org.hammerlab.guacamole.commands.jointcaller.evidence

import org.hammerlab.guacamole.commands.jointcaller.AlleleAtLocus
import org.hammerlab.guacamole.commands.jointcaller.annotation.SingleSampleSingleAlleleAnnotation.NamedAnnotations

/**
 * Summary of evidence for an allele at a site in a single sample. This trait is implemented by tissue- and
 * analyte-specific classes.
 *
 * The classes implementing this should be serializable. They should gather all the per-sample information needed to
 * call or not call a variant. They do not themselves call variants, however, as that requires looking across multiple
 * samples.
 */
trait SingleSampleSingleAlleleEvidence {

  /** The allele under consideration */
  val allele: AlleleAtLocus

  /** extra information, including filters, we compute about a potential call */
  val annotations: NamedAnnotations

  /** return a new instance include the given annotations */
  def withAnnotations(annotations: NamedAnnotations): SingleSampleSingleAlleleEvidence

  /** filters that are failing for this sample */
  def failingFilters: NamedAnnotations = {
    annotations.filter(_._2.isFiltered)
  }
}