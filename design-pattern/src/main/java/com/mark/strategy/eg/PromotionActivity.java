package com.mark.strategy.eg;

/**
 * @author Mark
 * @date 2020/5/14 11:12
 */
public class PromotionActivity {

    private IPromotionStrategy strategy;

    public PromotionActivity(IPromotionStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.promotion();
    }

}
