package model;

import java.util.Date;

public class Listing_new {

    public Status status;
    public Datum[] data;

}

class Status
{
    public Date timestamp;
    public int error_code;
    public String error_message;
    public int elapsed;
    public int credit_count;
}

class Datum
{
    public int id;
    public String name;
    public String symbol;
    public String slug;
    public float circulating_supply;
    public float total_supply;
    public long max_supply;
    public Date  date_added;
    public int num_market_pairs;
    public String[] tags;
    public Platform platform;
    public int cmc_rank;
    public Date last_updated;
    public Quote quote;
}

class Platform
{
    public int id;
    public String name;
    public String symbol;
    public String slug;
    public String token_address;
}

class Quote
{
    public USD USD;
}

class USD
{
    public float price;
    public float volume_24h;
    public float percent_change_1h;
    public float percent_change_24h;
    public float percent_change_7d;
    public float market_cap;
    public java.sql.Date last_updated;
}
