package com.pellucid.aws.dynamodb.models;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import scala.collection.JavaConverters;
import scala.collection.JavaConversions;

import aws.dynamodb.DDBAttribute;

public class ItemResponse {

    private final Map<String, AttributeValue> item;
    private final BigDecimal consumedCapacityUnits;

    public ItemResponse(Map<String, AttributeValue> item, BigDecimal consumedCapacityUnits) {
        this.item = item;
        this.consumedCapacityUnits = consumedCapacityUnits;
    }

    public Map<String, AttributeValue> item() {
        return new HashMap<String, AttributeValue>(this.item);
    }

    public BigDecimal consumedCapacityUnits() {
        return this.consumedCapacityUnits;
    }

    public static ItemResponse fromScala(aws.dynamodb.models.ItemResponse scalaResponse) {
        Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
        for (String key: JavaConversions.asJavaIterable(scalaResponse.item().keys())) {
            item.put(key, AttributeValue.fromScala(scalaResponse.item().apply(key)));
        }
        return new ItemResponse(item, scalaResponse.consumedCapacityUnits().underlying());
    }

}