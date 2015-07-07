package tradingproblems;

import java.io.IOException;
import java.util.Calendar;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;


public class TrendlineAlgorithm extends ApplicationFrame {
   private static final long serialVersionUID = 1L;
   private static double[][] dataPoints;
   private static JFreeChart lineChart;

   public TrendlineAlgorithm(String applicationTitle, String chartTitle, Stock stock) throws IOException {
      super(applicationTitle);
      lineChart =
            ChartFactory.createXYLineChart(chartTitle, "Time", "Price", createDataset(stock), PlotOrientation.VERTICAL,
                  true, true, false);

      ChartPanel chartPanel = new ChartPanel(lineChart);
      chartPanel.setPreferredSize(new java.awt.Dimension(1280, 720));
      setContentPane(chartPanel);
   }

   private XYDataset createDataset(Stock stock) throws IOException {
      dataPoints = new double[stock.getHistory().size()][];
      XYSeries dataSeries = new XYSeries(stock.getName());
      int i = 0;
      for (HistoricalQuote quote : stock.getHistory()) {
         long time = quote.getDate().getTimeInMillis();
         double adjClose = quote.getAdjClose().doubleValue();
         dataSeries.add(time, adjClose);
         dataPoints[i] = new double[2];
         dataPoints[i][0] = time;
         dataPoints[i][1] = adjClose;
      }
      XYSeriesCollection dataset = new XYSeriesCollection();
      dataset.addSeries(dataSeries);
      return dataset;
   }

   public static void main(String[] args) throws IOException {
      Calendar from = Calendar.getInstance();
      Calendar to = Calendar.getInstance();
      from.add(Calendar.YEAR, -5);
      Stock mchi = YahooFinance.get("MCHI", from, to, Interval.DAILY);

      TrendlineAlgorithm chart = new TrendlineAlgorithm("MCHI Price vs Time", "Dollars vs Time", mchi);

      chart.pack();
      RefineryUtilities.centerFrameOnScreen(chart);
      chart.setVisible(true);
   }
}
