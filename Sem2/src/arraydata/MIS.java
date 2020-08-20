
import java.io.IOException;
import java.util.List;

import com.github.sh0nk.matplotlib4j.NumpyUtils;
import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import com.github.sh0nk.matplotlib4j.builder.ContourBuilder;
package arraydata;

	public class MIS {
		@SuppressWarnings("unused")
		public static void main (String[] args) throws IOException, PythonExecutionException {
			  List<Double> x = NumpyUtils.linspace(-4, 3, 100);
			  List<Double> y = NumpyUtils.linspace(-4, 7, 100);
			  NumpyUtils.Grid<Double> grid = NumpyUtils.meshgrid(x, y);
			  List<List<Double>> zCalced = grid.calcZ((xi, yj) -> Math.sqrt(2*xi * xi + yj * yj + 2* xi*yj + xi - yj));
			  Plot plt = Plot.create();
			  ContourBuilder contour =plt.contour().add(x, y, zCalced);
			  plt.title("pcolor");
			  plt.legend();
			  plt.show();
			}
