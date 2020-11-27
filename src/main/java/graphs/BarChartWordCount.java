package graphs;

import java.io.File;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartWordCount {
    public static void main(String[ ] args)throws Exception {
        final String wordcount = "Top 10 Words Commonly Used";

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //from MapReduce
        dataset.addValue(6408015, wordcount, "the");
        dataset.addValue(3876100, wordcount, "of");
        dataset.addValue(2656757, wordcount, "and");
        dataset.addValue(2421776, wordcount, "in");
        dataset.addValue(1837184, wordcount, "a");
        dataset.addValue(1747629, wordcount, "to");
        dataset.addValue(840213, wordcount, "is");
        dataset.addValue(729974, wordcount, "as");
        dataset.addValue(691386, wordcount, "for");
        dataset.addValue(683618, wordcount, "by");

        JFreeChart barChart = ChartFactory.createBarChart(
                "Top 10 Commonly Used in Wikipedia",
                "Word", "Total Count",
                dataset, PlotOrientation.HORIZONTAL,
                true, true, false);
        int width = 640;    /* Width of the image */
        int height = 480;   /* Height of the image */
        File barChartObject = new File("BarChartWordCount.png");
        ChartUtilities.saveChartAsPNG(barChartObject, barChart, width, height);
    }
}
