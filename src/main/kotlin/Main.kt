package me.alex_s168

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import me.alex_s168.me.alex_s168.vxcc.ir.lang.*
import me.alex_s168.me.alex_s168.vxcc.ir.opt.OptPass
import me.alex_s168.me.alex_s168.vxcc.ir.opt.RemoveCodeAfterExit
import me.alex_s168.me.alex_s168.vxcc.ir.updateParents

private val json = Json {
    prettyPrint = true
}

private val optimizations = listOf<OptPass>(
    RemoveCodeAfterExit()
)

// TODO: SAVE REFERENCES TO RESOLVED VARIABLES IN VARREF

fun main() {
    val ircode = IRInstructionBlock(
        global = true,
        children = mutableListOf(
            IRTypeDefinition(
                name = "i8",
                size = 4,
                align = 0,
                float = false,
                signed = true,
                pointer = false
            ),

            IRFunctionDefinition(
                name = "putc",
                args = listOf(
                    IRVariableDefinition("chr", "i8")
                ),
                ret = null,
                inline = false,
                extern = true,
                noinline = false,
                noreturn = false,
                pure = false,
                export = false,
                abi = "c",
                section = null,
                align = 0,
                body = null
            ),

            IRFunctionDefinition(
                name = "main",
                args = listOf(),
                ret = "i8",
                inline = false,
                extern = false,
                noinline = false,
                noreturn = false,
                pure = false,
                export = true,
                abi = null,
                section = null,
                align = 0,
                body = IRInstructionBlock(
                    global = false,
                    children = mutableListOf(
                        IRCall(
                            func = IRVarRefExpr(
                                name = "putc",
                                reinterpret = null
                            ),
                            args = listOf(
                                IRConstIntExpr(
                                    value = 65,
                                    typ = "i8"
                                )
                            ),
                            resultType = null,
                            abi = "c",
                            noinline = false
                        ),

                        IRReturnStmt(
                            value = IRConstIntExpr(
                                value = 0,
                                typ = "i8"
                            )
                        ),

                        // should be removed.
                        IRReturnStmt(
                            value = IRConstIntExpr(
                                value = 0,
                                typ = "i8"
                            )
                        )
                    )
                )
            )
        )
    )

    ircode.updateParents()

    optimizations.forEach { it.runOnGlobal(ircode) }

    val ir = json.encodeToString(ircode)

    println(ir)
}