package sec03.brd01;

import java.util.List;

public class BoardService {
	BoardDAO boardDAO;

	public BoardService() {
		boardDAO = new BoardDAO();
	}

	public List<ArticleVO> listArticles() {
		// TODO Auto-generated method stub
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}

	public void addArticle(ArticleVO article) {
		// TODO Auto-generated method stub
		boardDAO.insertNewArticle(article);
	}
}
