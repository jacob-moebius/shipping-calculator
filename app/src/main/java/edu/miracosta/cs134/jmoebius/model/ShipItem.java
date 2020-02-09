package edu.miracosta.cs134.jmoebius.model;

/**
 * Stores shipping information and calculates cost of shipping item of some weight.
 */
public class ShipItem {

    /**
     * Weight of item shipping, base cost to ship item, added cost to ship item over 16 oz., total
     * cost to ship item.
     */
    private double mWeight;
    private double mBaseCost;
    private double mAddedCost;
    private double mTotalShippingCost;

    /**
     * Contructor initializes member variables to default variables. Note the base cost is $3.00.
     */
    public ShipItem()
    {
        mWeight = 0;
        mBaseCost = 3.00;
        mAddedCost = 0.0;
        mTotalShippingCost = 0.0;
    }

    // GETTERS
    /**
     * Returns the weight of the item shipping.
     *
     * @return mWeight      returns the weight of the item shipping
     */
    public double getWeight() {
        return mWeight;
    }

    /**
     * Returns the base cost of the item shipping.
     *
     * @return mBaseCost        returns the base cost of the item shipping
     */
    public double getBaseCost() {
        return mBaseCost;
    }

    /**
     * Returns the added cost of the item shipping.
     *
     * @return mAddedCost       returns the weight of the item shipping
     */
    public double getAddedCost() {
        return mAddedCost;
    }

    /**
     * Returns the weight of the item shipping.
     *
     * @return getTotalShippingCost     returns the weight of the item shipping
     */
    public double getTotalShippingCost() {
        return mTotalShippingCost;
    }

    /**
     * Sets the weight of item shipping and calls recalculateTotalShippingCost() to recalculate the
     * shipping cost.
     *
     * @param userEnteredWeight     user input of the weight of the item shipping
     */
    public void setWeight(double userEnteredWeight) {
        mWeight = userEnteredWeight;
        recalculateTotalShippingCost();
    }

    /**
     * Recalculates the shipping cost of the item shipping. To calculate the shipping cost, the
     * base cost of shipping is added to $0.50 for each additional 4 ounces (above 16). Additional
     * charges are calculated by dividing the difference of the weight and 16 oz by 4 and then
     * multiplying that quotient by 0.5.
     */
    private void recalculateTotalShippingCost() {
        if (mWeight > 16.0) {
            mAddedCost = Math.ceil((mWeight - 16.0) / 4.0) * 0.5;
        }
        else {
            mAddedCost = 0.0;
        }
        mTotalShippingCost = mBaseCost + mAddedCost;
    }
}
