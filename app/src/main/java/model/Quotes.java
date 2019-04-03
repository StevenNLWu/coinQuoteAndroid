package model;

import java.util.List;

public class Quotes {


    /**
     * status : {"timestamp":"2019-04-03T09:50:53.879Z","error_code":0,"error_message":null,"elapsed":6,"credit_count":1}
     * data : {"1":{"id":1,"name":"Bitcoin","symbol":"BTC","slug":"bitcoin","circulating_supply":17620525,"total_supply":17620525,"max_supply":21000000,"date_added":"2013-04-28T00:00:00.000Z","num_market_pairs":6950,"tags":["mineable"],"platform":null,"cmc_rank":1,"last_updated":"2019-04-03T09:49:32.000Z","quote":{"USD":{"price":4966.73686191,"volume_24h":2.11518837354079E10,"percent_change_1h":0.658644,"percent_change_24h":5.09541,"percent_change_7d":22.3771,"market_cap":8.75165110437067E10,"last_updated":"2019-04-03T09:49:32.000Z"}}},"2":{"id":2,"name":"Litecoin","symbol":"LTC","slug":"litecoin","circulating_supply":6.11735114890286E7,"total_supply":6.11735114890286E7,"max_supply":84000000,"date_added":"2013-04-28T00:00:00.000Z","num_market_pairs":546,"tags":["mineable"],"platform":null,"cmc_rank":4,"last_updated":"2019-04-03T09:50:07.000Z","quote":{"USD":{"price":81.4499894306,"volume_24h":4.88575719760372E9,"percent_change_1h":1.15733,"percent_change_24h":21.3982,"percent_change_7d":33.0274,"market_cap":4.982581864214067E9,"last_updated":"2019-04-03T09:50:07.000Z"}}},"3":{"id":3,"name":"Namecoin","symbol":"NMC","slug":"namecoin","circulating_supply":14736400,"total_supply":14736400,"max_supply":null,"date_added":"2013-04-28T00:00:00.000Z","num_market_pairs":10,"tags":["mineable"],"platform":null,"cmc_rank":253,"last_updated":"2019-04-03T09:50:02.000Z","quote":{"USD":{"price":0.948910782977,"volume_24h":16852.0359338714,"percent_change_1h":-0.00356196,"percent_change_24h":9.7108,"percent_change_7d":31.3694,"market_cap":1.3983528862262264E7,"last_updated":"2019-04-03T09:50:02.000Z"}}},"4":{"id":4,"name":"Terracoin","symbol":"TRC","slug":"terracoin","circulating_supply":2.29353964303612E7,"total_supply":2.29353964303612E7,"max_supply":42000000,"date_added":"2013-04-28T00:00:00.000Z","num_market_pairs":6,"tags":["mineable"],"platform":null,"cmc_rank":1339,"last_updated":"2019-04-03T09:50:02.000Z","quote":{"USD":{"price":0.0303705748411,"volume_24h":27.359031041791,"percent_change_1h":0.180257,"percent_change_24h":-5.71211,"percent_change_7d":34.064,"market_cap":696561.1737985826,"last_updated":"2019-04-03T09:50:02.000Z"}}},"5":{"id":5,"name":"Peercoin","symbol":"PPC","slug":"peercoin","circulating_supply":2.52930803157654E7,"total_supply":2.52930803157654E7,"max_supply":null,"date_added":"2013-04-28T00:00:00.000Z","num_market_pairs":15,"tags":["mineable"],"platform":null,"cmc_rank":243,"last_updated":"2019-04-03T09:50:02.000Z","quote":{"USD":{"price":0.579384318919,"volume_24h":168449.505217079,"percent_change_1h":-0.381972,"percent_change_24h":-1.51579,"percent_change_7d":9.67095,"market_cap":1.46544141121133E7,"last_updated":"2019-04-03T09:50:02.000Z"}}},"6":{"id":6,"name":"Novacoin","symbol":"NVC","slug":"novacoin","circulating_supply":2335756.713897,"total_supply":2335756.713897,"max_supply":null,"date_added":"2013-04-28T00:00:00.000Z","num_market_pairs":2,"tags":["mineable"],"platform":null,"cmc_rank":1315,"last_updated":"2019-04-03T09:50:01.000Z","quote":{"USD":{"price":0.510797924991,"volume_24h":464.784162770083,"percent_change_1h":1.25366,"percent_change_24h":6.3243,"percent_change_7d":25.1523,"market_cap":1193099.6827423845,"last_updated":"2019-04-03T09:50:01.000Z"}}},"8":{"id":8,"name":"Feathercoin","symbol":"FTC","slug":"feathercoin","circulating_supply":232637160,"total_supply":232637160,"max_supply":336000000,"date_added":"2013-05-03T00:00:00.000Z","num_market_pairs":7,"tags":["mineable"],"platform":null,"cmc_rank":490,"last_updated":"2019-04-03T09:50:01.000Z","quote":{"USD":{"price":0.0198929230405,"volume_24h":21684.2173729493,"percent_change_1h":4.03544,"percent_change_24h":7.60373,"percent_change_7d":23.4217,"market_cap":4627833.120240484,"last_updated":"2019-04-03T09:50:01.000Z"}}},"9":{"id":9,"name":"Mincoin","symbol":"MNC","slug":"mincoin","circulating_supply":5126724.88794916,"total_supply":5126724.88794916,"max_supply":null,"date_added":"2013-05-03T00:00:00.000Z","num_market_pairs":2,"tags":["mineable"],"platform":null,"cmc_rank":1565,"last_updated":"2019-04-03T09:50:02.000Z","quote":{"USD":{"price":0.012503104014,"volume_24h":103.16760433285,"percent_change_1h":0.678059,"percent_change_24h":27.6935,"percent_change_7d":49.2587,"market_cap":64099.974525190846,"last_updated":"2019-04-03T09:50:02.000Z"}}},"10":{"id":10,"name":"Freicoin","symbol":"FRC","slug":"freicoin","circulating_supply":3.24764532317972E7,"total_supply":100000000,"max_supply":null,"date_added":"2013-05-03T00:00:00.000Z","num_market_pairs":1,"tags":["mineable"],"platform":null,"cmc_rank":1435,"last_updated":"2019-04-03T09:50:02.000Z","quote":{"USD":{"price":0.0067509701461,"volume_24h":91.7091496235393,"percent_change_1h":0.651649,"percent_change_24h":-1.57284,"percent_change_7d":14.8082,"market_cap":219247.56621907576,"last_updated":"2019-04-03T09:50:02.000Z"}}}}
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
         * timestamp : 2019-04-03T09:50:53.879Z
         * error_code : 0
         * error_message : null
         * elapsed : 6
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
             * USD : {"price":4966.73686191,"volume_24h":2.11518837354079E10,"percent_change_1h":0.658644,"percent_change_24h":5.09541,"percent_change_7d":22.3771,"market_cap":8.75165110437067E10,"last_updated":"2019-04-03T09:49:32.000Z"}
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
                 * price : 4966.73686191
                 * volume_24h : 2.11518837354079E10
                 * percent_change_1h : 0.658644
                 * percent_change_24h : 5.09541
                 * percent_change_7d : 22.3771
                 * market_cap : 8.75165110437067E10
                 * last_updated : 2019-04-03T09:49:32.000Z
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
