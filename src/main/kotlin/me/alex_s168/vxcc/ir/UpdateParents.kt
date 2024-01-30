package me.alex_s168.me.alex_s168.vxcc.ir

import me.alex_s168.me.alex_s168.vxcc.ir.lang.IRInstructionBlock

fun IRInstructionBlock.updateParents() {
    for (child in children) {
        if (child is IRInstructionBlock) {
            child.parent = this
            child.updateParents()
        }
    }
}