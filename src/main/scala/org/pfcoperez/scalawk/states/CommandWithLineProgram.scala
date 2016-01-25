package org.pfcoperez.scalawk.states

import org.pfcoperez.scalawk.AwkCommand
import org.pfcoperez.scalawk.entities.{AwkExpression, SideEffectStatement}
import org.pfcoperez.scalawk.transitions.{ToCommandWithInitialProgram, ToSolidCommand}

class CommandWithLineProgram(
                              statements: Seq[SideEffectStatement]
                            )(prev: AwkCommand) extends AwkCommand
  with ToSolidCommand
  with ToCommandWithInitialProgram {

  override private[scalawk] val commandOptions: Seq[String] = prev.commandOptions
  override private[scalawk] val linePresentation: Seq[AwkExpression] = prev.linePresentation

  override val lineProgram: Seq[SideEffectStatement] = statements
  override private[scalawk] val initialProgram: Seq[SideEffectStatement] = prev.initialProgram
  override private[scalawk] val endProgram: Seq[SideEffectStatement] = prev.endProgram

}
