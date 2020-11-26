package space.harbour.java.project;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;

public class LineChartSumPageViews {
    public static void main(String[] args) throws Exception {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(5.38, "sumviews", "2007120100");
        dataset.addValue(9.16, "sumviews", "2008010100");
        dataset.addValue(8.85, "sumviews", "2008020100");
        dataset.addValue(9.2, "sumviews", "2008030100");
        dataset.addValue(9.65, "sumviews", "2008040100");
        dataset.addValue(10.7, "sumviews", "2008050100");
        dataset.addValue(10.87, "sumviews", "2008060100");
        dataset.addValue(9.88, "sumviews", "2008070100");
        dataset.addValue(9.83, "sumviews", "2008080100");
        dataset.addValue(10.64, "sumviews", "2008090100");
        dataset.addValue(11.07, "sumviews", "2008100100");
        dataset.addValue(10.85, "sumviews", "2008110100");
        dataset.addValue(10.83, "sumviews", "2008120100");
        dataset.addValue(11.89, "sumviews", "2009010100");
        dataset.addValue(10.91, "sumviews", "2009020100");
        dataset.addValue(12.43, "sumviews", "2009030100");
        dataset.addValue(11.36, "sumviews", "2009040100");
        dataset.addValue(12.22, "sumviews", "2009050100");
        dataset.addValue(11.52, "sumviews", "2009060100");
        dataset.addValue(11.13, "sumviews", "2009070100");
        dataset.addValue(11.31, "sumviews", "2009080100");
        dataset.addValue(8.07, "sumviews", "2009090100");
        dataset.addValue(12.21, "sumviews", "2009100100");
        dataset.addValue(11.86, "sumviews", "2009110100");
        dataset.addValue(10.97, "sumviews", "2009120100");
        dataset.addValue(11.62, "sumviews", "2010010100");
        dataset.addValue(11.59, "sumviews", "2010020100");
        dataset.addValue(12.62, "sumviews", "2010030100");
        dataset.addValue(12.12, "sumviews", "2010040100");
        dataset.addValue(12.02, "sumviews", "2010050100");
        dataset.addValue(9.15, "sumviews", "2010060100");
        dataset.addValue(9.62, "sumviews", "2010070100");
        dataset.addValue(13.82, "sumviews", "2010080100");
        dataset.addValue(14.75, "sumviews", "2010090100");
        dataset.addValue(21.2, "sumviews", "2010100100");
        dataset.addValue(13.92, "sumviews", "2010110100");
        dataset.addValue(13.79, "sumviews", "2010120100");
        dataset.addValue(15.14, "sumviews", "2011010100");
        dataset.addValue(13.86, "sumviews", "2011020100");
        dataset.addValue(15.01, "sumviews", "2011030100");
        dataset.addValue(13.9, "sumviews", "2011040100");
        dataset.addValue(14.79, "sumviews", "2011050100");
        dataset.addValue(13.78, "sumviews", "2011060100");
        dataset.addValue(13.66, "sumviews", "2011070100");
        dataset.addValue(13.79, "sumviews", "2011080100");
        dataset.addValue(12.47, "sumviews", "2011090100");
        dataset.addValue(15.47, "sumviews", "2011100100");
        dataset.addValue(16.11, "sumviews", "2011110100");
        dataset.addValue(13.53, "sumviews", "2011120100");
        dataset.addValue(16.91, "sumviews", "2012010100");
        dataset.addValue(15.92, "sumviews", "2012020100");
        dataset.addValue(15.94, "sumviews", "2012030100");
        dataset.addValue(15.23, "sumviews", "2012040100");
        dataset.addValue(16.6, "sumviews", "2012050100");
        dataset.addValue(16.01, "sumviews", "2012060100");
        dataset.addValue(16.12, "sumviews", "2012070100");
        dataset.addValue(16.49, "sumviews", "2012080100");
        dataset.addValue(16.81, "sumviews", "2012090100");
        dataset.addValue(18.01, "sumviews", "2012100100");
        dataset.addValue(17.78, "sumviews", "2012110100");
        dataset.addValue(17.06, "sumviews", "2012120100");
        dataset.addValue(19.38, "sumviews", "2013010100");
        dataset.addValue(17.36, "sumviews", "2013020100");
        dataset.addValue(18.97, "sumviews", "2013030100");
        dataset.addValue(17.67, "sumviews", "2013040100");
        dataset.addValue(18.21, "sumviews", "2013050100");
        dataset.addValue(17.51, "sumviews", "2013060100");
        dataset.addValue(18.29, "sumviews", "2013070100");
        dataset.addValue(20.96, "sumviews", "2013080100");
        dataset.addValue(22.26, "sumviews", "2013090100");
        dataset.addValue(24.25, "sumviews", "2013100100");
        dataset.addValue(23.62, "sumviews", "2013110100");
        dataset.addValue(15.5, "sumviews", "2013120100");
        dataset.addValue(15.62, "sumviews", "2014010100");
        dataset.addValue(15.17, "sumviews", "2014020100");
        dataset.addValue(16.86, "sumviews", "2014030100");
        dataset.addValue(15.95, "sumviews", "2014040100");
        dataset.addValue(16.37, "sumviews", "2014050100");
        dataset.addValue(15.01, "sumviews", "2014060100");
        dataset.addValue(15.34, "sumviews", "2014070100");
        dataset.addValue(15.58, "sumviews", "2014080100");
        dataset.addValue(17.1, "sumviews", "2014090100");
        dataset.addValue(22.12, "sumviews", "2014100100");
        dataset.addValue(21.02, "sumviews", "2014110100");
        dataset.addValue(21.43, "sumviews", "2014120100");
        dataset.addValue(21.52, "sumviews", "2015010100");
        dataset.addValue(19.19, "sumviews", "2015020100");
        dataset.addValue(21.25, "sumviews", "2015030100");
        dataset.addValue(20.74, "sumviews", "2015040100");
        dataset.addValue(21.21, "sumviews", "2015050100");
        dataset.addValue(18.01, "sumviews", "2015060100");
        dataset.addValue(18.76, "sumviews", "2015070100");
        dataset.addValue(18.14, "sumviews", "2015080100");
        dataset.addValue(18.63, "sumviews", "2015090100");
        dataset.addValue(19.38, "sumviews", "2015100100");
        dataset.addValue(19.14, "sumviews", "2015110100");
        dataset.addValue(19.19, "sumviews", "2015120100");
        dataset.addValue(20.59, "sumviews", "2016010100");
        dataset.addValue(19.18, "sumviews", "2016020100");
        dataset.addValue(19.91, "sumviews", "2016030100");
        dataset.addValue(19.77, "sumviews", "2016040100");
        dataset.addValue(19.66, "sumviews", "2016050100");
        dataset.addValue(18.45, "sumviews", "2016060100");
        dataset.addValue(18.61, "sumviews", "2016070100");
        dataset.addValue(2.85, "sumviews", "2016080100");

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Sum of Page Views", "Date (December 2007 - August 2016)",
                "Sum of Page Views (in Billion)",
                dataset, PlotOrientation.VERTICAL,
                true, true, false);

        int width = 640;    /* Width of the image */
        int height = 480;   /* Height of the image */
        File lineChartSumPageViews = new File("LineChartSumPageViews.jpeg");
        ChartUtilities.saveChartAsPNG(lineChartSumPageViews, lineChartObject, width, height);
    }
}