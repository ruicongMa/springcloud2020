package com.mark.inerpreter.eg;

/**
 * @author Mark
 * @date 2020/5/25 17:32
 */
public class NumberInterpreter implements IArithmeticlnterpreter {

    private int value;

    public NumberInterpreter(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return this.value;
    }
}
