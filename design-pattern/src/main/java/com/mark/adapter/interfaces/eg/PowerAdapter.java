package com.mark.adapter.interfaces.eg;

/**
 * @author Mark
 * @date 2020/5/10 15:28
 */
public class PowerAdapter implements DC {

    private AC220V ac220V;

    public PowerAdapter(AC220V ac220V) {
        this.ac220V = ac220V;
    }

    @Override
    public int output5V() {
        int outputAC220V = this.ac220V.outputAC220V();
        int adapterOutput = outputAC220V / 44;
        System.out.println("使用 Adapter 输入 AC" + outputAC220V + "V，输出DC：" + adapterOutput + "V");
        return adapterOutput;
    }

    @Override
    public int output12V() {
        return 0;
    }

    @Override
    public int output24V() {
        return 0;
    }

    @Override
    public int output36V() {
        return 0;
    }

}
