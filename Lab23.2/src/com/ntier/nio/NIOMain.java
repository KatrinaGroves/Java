package com.ntier.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

class NIOMain {

	public static void main(String[] args) {
		String pathString = args[0];
		String globString = args[1];
		Path pth = Paths.get(pathString);
		PathMatcher pm = FileSystems.getDefault().getPathMatcher(globString);
		try (DirectoryStream<Path> ds = Files.newDirectoryStream(pth)) {
			for (Path currentPath : ds) {
				if (pm.matches(currentPath)) {
					System.out.println(currentPath);
				} else {
					System.out.println("Nothing matches");
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
