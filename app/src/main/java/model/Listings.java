package model;

import java.util.List;

public class Listings {


    /**
     * status : {"timestamp":"2019-03-04T06:01:53.670Z","error_code":0,"error_message":null,"elapsed":5,"credit_count":1}
     * data : [{"id":1,"name":"Bitcoin","symbol":"BTC","slug":"bitcoin","circulating_supply":17569887,"total_supply":17569887,"max_supply":21000000,"date_added":"2013-04-28T00:00:00.000Z","num_market_pairs":6722,"tags":["mineable"],"platform":null,"cmc_rank":1,"last_updated":"2019-03-04T06:01:26.000Z","quote":{"USD":{"price":3779.07329418,"volume_24h":7.70480810208912E9,"percent_change_1h":-0.589218,"percent_change_24h":-2.21444,"percent_change_7d":-1.48092,"market_cap":6.639789074346036E10,"last_updated":"2019-03-04T06:01:26.000Z"}}},{"id":1027,"name":"Ethereum","symbol":"ETH","slug":"ethereum","circulating_supply":1.051147066241E8,"total_supply":1.051147066241E8,"max_supply":null,"date_added":"2015-08-07T00:00:00.000Z","num_market_pairs":4766,"tags":["mineable"],"platform":null,"cmc_rank":2,"last_updated":"2019-03-04T06:01:15.000Z","quote":{"USD":{"price":129.250895023,"volume_24h":3.65577590487688E9,"percent_change_1h":-0.138163,"percent_change_24h":-4.33749,"percent_change_7d":-7.13556,"market_cap":1.3586169911244991E10,"last_updated":"2019-03-04T06:01:15.000Z"}}}]
     */

    private StatusBean status;
    private List<DataBean> data;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class StatusBean {
        /**
         * timestamp : 2019-03-04T06:01:53.670Z
         * error_code : 0
         * error_message : null
         * elapsed : 5
         * credit_count : 1
         */

        private String timestamp;
        private int error_code;
        private Object error_message;
        private int elapsed;
        private int credit_count;

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public int getError_code() {
            return error_code;
        }

        public void setError_code(int error_code) {
            this.error_code = error_code;
        }

        public Object getError_message() {
            return error_message;
        }

        public void setError_message(Object error_message) {
            this.error_message = error_message;
        }

        public int getElapsed() {
            return elapsed;
        }

        public void setElapsed(int elapsed) {
            this.elapsed = elapsed;
        }

        public int getCredit_count() {
            return credit_count;
        }

        public void setCredit_count(int credit_count) {
            this.credit_count = credit_count;
        }
    }

    public static class DataBean {
        /**
         * id : 1
         * name : Bitcoin
         * symbol : BTC
         * slug : bitcoin
         * circulating_supply : 17569887
         * total_supply : 17569887
         * max_supply : 21000000
         * date_added : 2013-04-28T00:00:00.000Z
         * num_market_pairs : 6722
         * tags : ["mineable"]
         * platform : null
         * cmc_rank : 1
         * last_updated : 2019-03-04T06:01:26.000Z
         * quote : {"USD":{"price":3779.07329418,"volume_24h":7.70480810208912E9,"percent_change_1h":-0.589218,"percent_change_24h":-2.21444,"percent_change_7d":-1.48092,"market_cap":6.639789074346036E10,"last_updated":"2019-03-04T06:01:26.000Z"}}
         */

        private int id;
        private String name;
        private String symbol;
        private String slug;
        private int circulating_supply;
        private int total_supply;
        private int max_supply;
        private String date_added;
        private int num_market_pairs;
        private Object platform;
        private int cmc_rank;
        private String last_updated;
        private QuoteBean quote;
        private List<String> tags;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public int getCirculating_supply() {
            return circulating_supply;
        }

        public void setCirculating_supply(int circulating_supply) {
            this.circulating_supply = circulating_supply;
        }

        public int getTotal_supply() {
            return total_supply;
        }

        public void setTotal_supply(int total_supply) {
            this.total_supply = total_supply;
        }

        public int getMax_supply() {
            return max_supply;
        }

        public void setMax_supply(int max_supply) {
            this.max_supply = max_supply;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public int getNum_market_pairs() {
            return num_market_pairs;
        }

        public void setNum_market_pairs(int num_market_pairs) {
            this.num_market_pairs = num_market_pairs;
        }

        public Object getPlatform() {
            return platform;
        }

        public void setPlatform(Object platform) {
            this.platform = platform;
        }

        public int getCmc_rank() {
            return cmc_rank;
        }

        public void setCmc_rank(int cmc_rank) {
            this.cmc_rank = cmc_rank;
        }

        public String getLast_updated() {
            return last_updated;
        }

        public void setLast_updated(String last_updated) {
            this.last_updated = last_updated;
        }

        public QuoteBean getQuote() {
            return quote;
        }

        public void setQuote(QuoteBean quote) {
            this.quote = quote;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public static class QuoteBean {
            /**
             * USD : {"price":3779.07329418,"volume_24h":7.70480810208912E9,"percent_change_1h":-0.589218,"percent_change_24h":-2.21444,"percent_change_7d":-1.48092,"market_cap":6.639789074346036E10,"last_updated":"2019-03-04T06:01:26.000Z"}
             */

            private USDBean USD;

            public USDBean getUSD() {
                return USD;
            }

            public void setUSD(USDBean USD) {
                this.USD = USD;
            }

            public static class USDBean {
                /**
                 * price : 3779.07329418
                 * volume_24h : 7.70480810208912E9
                 * percent_change_1h : -0.589218
                 * percent_change_24h : -2.21444
                 * percent_change_7d : -1.48092
                 * market_cap : 6.639789074346036E10
                 * last_updated : 2019-03-04T06:01:26.000Z
                 */

                private double price;
                private double volume_24h;
                private double percent_change_1h;
                private double percent_change_24h;
                private double percent_change_7d;
                private double market_cap;
                private String last_updated;

                public double getPrice() {
                    return price;
                }

                public void setPrice(double price) {
                    this.price = price;
                }

                public double getVolume_24h() {
                    return volume_24h;
                }

                public void setVolume_24h(double volume_24h) {
                    this.volume_24h = volume_24h;
                }

                public double getPercent_change_1h() {
                    return percent_change_1h;
                }

                public void setPercent_change_1h(double percent_change_1h) {
                    this.percent_change_1h = percent_change_1h;
                }

                public double getPercent_change_24h() {
                    return percent_change_24h;
                }

                public void setPercent_change_24h(double percent_change_24h) {
                    this.percent_change_24h = percent_change_24h;
                }

                public double getPercent_change_7d() {
                    return percent_change_7d;
                }

                public void setPercent_change_7d(double percent_change_7d) {
                    this.percent_change_7d = percent_change_7d;
                }

                public double getMarket_cap() {
                    return market_cap;
                }

                public void setMarket_cap(double market_cap) {
                    this.market_cap = market_cap;
                }

                public String getLast_updated() {
                    return last_updated;
                }

                public void setLast_updated(String last_updated) {
                    this.last_updated = last_updated;
                }
            }
        }
    }
}
