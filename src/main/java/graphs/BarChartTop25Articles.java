package graphs;

import java.io.File;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartTop25Articles {
    public static void main(String[ ] args)throws Exception {
        final String mapReduce = "Top 25 Articles from MapReduce";
        final String fromWiki = "Articles from Wikipedia Top 25";

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //from MapReduce
        dataset.addValue(10184695, mapReduce, "Donald Trump");
        dataset.addValue(2850537, mapReduce, "Diana, Princess of Wales");
        dataset.addValue(2350101, mapReduce, "Megan is Missing");
        dataset.addValue(2250954, mapReduce, "Elizabeth II");
        dataset.addValue(2177170, mapReduce, "Louis Mountbatten, 1st Earl Mountbatten of Burma");
        dataset.addValue(2023240, mapReduce, "Princess Margaret, Countess of Snowdon");
        dataset.addValue(1752864, mapReduce, "Charles, Prince of Wales");
        dataset.addValue(1535819, mapReduce, "The Queen's Gambit (miniseries)");
        dataset.addValue(1385813, mapReduce, "Anne, Princess Royal");
        dataset.addValue(1219780, mapReduce, "Prince Philip, Duke of Edinburgh");
        dataset.addValue(1204688, mapReduce, "2020 United States presidential election");
        dataset.addValue(1167963, mapReduce, "The Crown (TV series)");
        dataset.addValue(1146805, mapReduce, "Michael Fagan (intruder)");
        dataset.addValue(1130217, mapReduce, "The Crown (season 4)");
        dataset.addValue(1104326, mapReduce, "Camilla, Duchess of Cornwall");
        dataset.addValue(1064908, mapReduce, "Prince Edward, Earl of Wessex");
        dataset.addValue(1064192, mapReduce, "Mark Thatcher");
        dataset.addValue(1010525, mapReduce, "Anya Taylor-Joy");
        dataset.addValue(904725, mapReduce, "Dustin Johnson");
        dataset.addValue(874007, mapReduce, "Prince Andrew, Duke of York");
        dataset.addValue(867108, mapReduce, "George VI");
        dataset.addValue(831095, mapReduce, "Deaths in 2020");
        dataset.addValue(787227, mapReduce, "Joe Biden");
        dataset.addValue(675484, mapReduce, "Jordan North");
        //from Wikipedia to 25
        dataset.addValue(6387834, fromWiki, "Donald Trump");
        dataset.addValue(2929180, fromWiki, "Margaret Thatcher");
        dataset.addValue(2839941, fromWiki, "Diana, Princess of Wales");
        dataset.addValue(2340447, fromWiki, "Megan is Missing");
        dataset.addValue(2241692, fromWiki, "Elizabeth II");
        dataset.addValue(2169279, fromWiki, "Louis Mountbatten, 1st Earl Mountbatten of Burma");
        dataset.addValue(2018293, fromWiki, "Princess Margaret, Countess of Snowdon");
        dataset.addValue(1747672, fromWiki, "Charles, Prince of Wales");
        dataset.addValue(1526501, fromWiki, "The Queen's Gambit (miniseries)");
        dataset.addValue(1381775, fromWiki, "Anne, Princess Royal");
        dataset.addValue(1214063, fromWiki, "Prince Philip, Duke of Edinburgh");
        dataset.addValue(1187306, fromWiki, "2020 United States presidential election");
        dataset.addValue(1160739, fromWiki, "The Crown (TV series)");
        dataset.addValue(1142299, fromWiki, "Michael Fagan (intruder)");
        dataset.addValue(1120918, fromWiki, "The Crown (season 4)");
        dataset.addValue(1099346, fromWiki, "Camilla, Duchess of Cornwall");
        dataset.addValue(1060768, fromWiki, "Prince Edward, Earl of Wessex");
        dataset.addValue(1059742, fromWiki, "Mark Thatcher");
        dataset.addValue(1006082, fromWiki, "Anya Taylor-Joy");
        dataset.addValue(901263, fromWiki, "Dustin Johnson");
        dataset.addValue(871237, fromWiki, "Prince Andrew, Duke of York");
        dataset.addValue(863130, fromWiki, "George VI");
        dataset.addValue(808802, fromWiki, "Deaths in 2020");
        dataset.addValue(770377, fromWiki, "Joe Biden");
        dataset.addValue(673774, fromWiki, "Jordan North");

        JFreeChart barChart = ChartFactory.createBarChart(
                "Top 25 Articles Viewed in Wikipedia",
                "Articles", "Total Views (15-21 November 2020)",
                dataset, PlotOrientation.HORIZONTAL,
                true, true, false);
        int width = 640;    /* Width of the image */
        int height = 480;   /* Height of the image */
        File barChartObject = new File("BarChartTop25Articles.png");
        ChartUtilities.saveChartAsPNG(barChartObject, barChart, width, height);
    }
}
