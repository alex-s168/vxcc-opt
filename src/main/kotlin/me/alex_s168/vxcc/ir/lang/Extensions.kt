package me.alex_s168.me.alex_s168.vxcc.ir.lang

fun IRInstructionBlock.withAllParents(): Sequence<IRInstructionBlock> {
    var current = this
    return generateSequence(this) {
        val parent = current.parent
        if (parent != null) {
            current = parent
            current
        } else {
            null
        }
    }
}

fun IRInstructionBlock.functions(): Sequence<IRFunctionDefinition> =
    this.withAllParents()
        .flatMap { it.children }
        .filterIsInstance<IRFunctionDefinition>()

fun IRInstructionBlock.variables(): Sequence<IRVariableDefinition> =
    this.withAllParents()
        .flatMap { it.children }
        .filterIsInstance<IRVariableDefinition>()

fun IRInstructionBlock.types(): Sequence<IRTypeDefinition> =
    this.withAllParents()
        .flatMap { it.children }
        .filterIsInstance<IRTypeDefinition>()

fun IRCall.staticFunction(parent: IRInstructionBlock): IRFunctionDefinition? =
    (func as? IRVarRefExpr)?.let { f ->
        parent.functions().find { it.name == f.name }
    }

fun IRElement.willStopFunctionFlow(parent: IRInstructionBlock): Boolean =
    when (this) {
        is IRCall -> this.staticFunction(parent)?.noreturn == true
        is IRReturnStmt -> true
        is IRInstructionBlock -> this.children.any { it.willStopFunctionFlow(this) }
        else -> false
    }