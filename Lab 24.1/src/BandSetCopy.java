import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

class BandSetCopy {

	public static void main(String[] args) {

		try(Stream<String> bands = Files.lines(Paths.get("BandList.txt"))) {
			System.out.println(bands);
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("File Not Found" + e);
		}
	}
}