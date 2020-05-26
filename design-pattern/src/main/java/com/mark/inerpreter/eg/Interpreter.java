package com.mark.inerpreter.eg;

/**
 * @author Mark
 * @date 2020/5/25 17:24
 */
public abstract class Interpreter implements IArithmeticlnterpreter {

    protected IArithmeticlnterpreter left;
    protected IArithmeticlnterpreter right;

    public Interpreter(IArithmeticlnterpreter left, IArithmeticlnterpreter right) {
        this.left = left;
        this.right = right;
    }
}
