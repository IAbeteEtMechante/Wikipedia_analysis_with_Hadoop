package space.harbour.java.project;

import java.io.File;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartTop25Articles {
    public static void main(String[ ] args)throws Exception {
        final String views = "Total Views";

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10184695, views, "Donald Trump");
        dataset.addValue(2850537, views, "Diana, Princess of Wales");
        dataset.addValue(2350101, views, "Megan Is Missing");
        dataset.addValue(2250954, views, "Elizabeth II");
        dataset.addValue(2177170, views, "Louis Mountbatten, 1st Earl Mountbatten of Burma");
        dataset.addValue(2023240, views, "Princess Margaret, Countess of Snowdon");
        dataset.addValue(1752864, views, "Charles, Prince of Wales");
        dataset.addValue(1535819, views, "The Queen's Gambit (miniseries)");
        dataset.addValue(1385813, views, "Anne, Princess Royal");
        dataset.addValue(1219780, views, "Prince Philip, Duke of Edinburgh");
        dataset.addValue(1204688, views, "2020 United States presidential election");
        dataset.addValue(1167963, views, "The Crown (TV series)");
        dataset.addValue(1146805, views, "Michael Fagan (intruder)");
        dataset.addValue(1130217, views, "The Crown (season 4)");
        dataset.addValue(1104326, views, "Camilla, Duchess of Cornwall");
        dataset.addValue(1064908, views, "Prince Edward, Earl of Wessex");
        dataset.addValue(1064192, views, "Mark Thatcher");
        dataset.addValue(1010525, views, "Anya Taylor-Joy");
        dataset.addValue(904725, views, "Dustin Johnson");
        dataset.addValue(874007, views, "Prince Andrew, Duke of York");
        dataset.addValue(867108, views, "George VI");
        dataset.addValue(831095, views, "Deaths in 2020");
        dataset.addValue(787227, views, "Joe Biden");
        dataset.addValue(675484, views, "Jordan North");


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