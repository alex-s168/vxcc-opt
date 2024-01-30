package me.alex_s168.me.alex_s168.vxcc.ir.lang

import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable

@Serializable
sealed interface IRConstNumExpr: IRElement

@Serializable
@Polymorphic
class IRConstIntExpr(
    val value: Long,
    val typ: String,
): IRConstNumExpr

@Serializable
@Polymorphic
class IRConstFloatExpr(
    val value: Double,
    val typ: String,
): IRConstNumExpr