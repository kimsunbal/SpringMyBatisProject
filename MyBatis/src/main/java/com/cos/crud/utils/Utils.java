package com.cos.crud.utils;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cos.crud.model.UserBoard;

public class Utils {
	// 미리보기 이미지 가져오기 유튜브 추가버전
	public static void setPreviewImg(List<UserBoard> boards) {
		for (UserBoard board : boards) {
			if (board.getContent() != null) {
				Document doc = Jsoup.parse(board.getContent());
				Elements etyoutube = doc.select("a");
				Element et = doc.selectFirst("img");
				String thumbnail = "";
				if (etyoutube != null) {
					for (Element element : etyoutube) {
						String href = element.attr("href");
						String value = element.text();
						if (href.contains("https://www.youtube.com/watch") && !value.equals("")) {
							String video[] = href.split("=");
							String v = video[1];
							thumbnail = "http://i.ytimg.com/vi/" + v + "/0.jpg";
							board.setPreviewImg(thumbnail);
							break;
						}
					}
				}
				if (thumbnail.equals("")) {
					if (et != null) {
						String previewImg = et.attr("src");// 이미지 소스 찾기
						board.setPreviewImg(previewImg);
					} else {
						board.setPreviewImg("/blog/img/storm_unplash.jpg");
					}
				}
			} else {
				board.setPreviewImg("/blog/img/storm_unplash.jpg");
			}
		}
	}

	public static String getPureContent(String content) {

		String searchContent = "";
		try {
			Document doc;
			doc = Jsoup.parse(content);
			Elements spanTags = doc.getAllElements();
			for (Element spanTag : spanTags) {
				searchContent += spanTag.ownText();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchContent;
	}
}
