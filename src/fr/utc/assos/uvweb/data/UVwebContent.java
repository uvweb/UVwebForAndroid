package fr.utc.assos.uvweb.data;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Helper class for providing UV content for user interfaces
 */
public class UVwebContent {
	/**
	 * UV title format pattern, consistent accross the application.
	 */
	public static final String UV_TITLE_FORMAT = "<font color='#000000'>%1$s</font>%2$s";
    public static final String UV_TITLE_FORMAT_LIGHT = "<font color='#ffffff'>%1$s</font>%2$s";

	public static final String NEWSFEED_ACTION_FORMAT = "<b>%1$s</b><font color='#000000'>%2$s</font>";

	/**
	 * An array of UVs.
	 */
	public static List<UV> UVS = new ArrayList<UV>();

	/**
	 * A map of UVs, by ID.
	 */
	public static Map<String, UV> UV_MAP = new HashMap<String, UV>();

	/**
	 * An array of comments.
	 */
	public static ArrayList<UVComment> COMMENTS = new ArrayList<UVComment>();

	/**
	 * An array of news feed entries.
	 */
	public static ArrayList<NewsFeedEntry> NEWS_ENTRIES = new ArrayList<NewsFeedEntry>();

	static {
		// Add sample items.
		addItem(new UV("MT23", "Algèbre linéaire", 8, 56.89));
		addItem(new UV("CM11", "Chimie générale", 2.7, 56.89));
		addItem(new UV("PS91", "Mécanique physique", 4.5, 56.89));
		addItem(new UV("PS04", "Thermodynamique", 5.2, 56.89));
		addItem(new UV("NF16", "Algorithmique et structures de données", 6.45, 56.89));
		addItem(new UV("HE03", "Logique : histoire et formalisme", 7.97, 56.89));
		addItem(new UV("MT91", "Fonctions d'une variable réelle 2", 8.34, 56.89));
		addItem(new UV("IA01", "Intelligence artificielle : apprentissage, représentation", 8, 56.89));
		addItem(new UV("MI01", "Structure d'un calculateur", 8, 56.89));
		addItem(new UV("SY01", "Elements de probabilités", 8, 56.89));
		addItem(new UV("LO21", "Programmation et conception orientées objet", 8, 56.89));
		addItem(new UV("SI07", "Médias classiques et médias numériques", 8, 56.89));
		addItem(new UV("SC22", "Sociologie cognitive, lien social et techniques", 8, 100));
		addItem(new UV("TN04", "Réalisation", 8, 100));
		addItem(new UV("AR03", "Art et technologies contemporaines", 8, 100));
		addItem(new UV("CM12", "Chimie physique minérale", 8, 100));
		addItem(new UV("BL01", "Sciences biologiques pour l'ingénieur", 8, 100));
		addItem(new UV("NF17", "Conception de bases de données", 8, 100));
		addItem(new UV("BL09", "Biophysique des systèmes biologiques", 8, 100));
		addItem(new UV("MT12", "Techniques mathématiques de l'ingénieur", 8, 100));
		addItem(new UV("MT23", "Algèbre linéaire", 8, 56.89));
		addItem(new UV("CM11", "Chimie générale", 2.7, 56.89));
		addItem(new UV("PS91", "Mécanique physique", 4.5, 56.89));
		addItem(new UV("PS04", "Thermodynamique", 5.2, 56.89));
		addItem(new UV("NF16", "Algorithmique et structures de données", 6.45, 56.89));
		addItem(new UV("HE03", "Logique : histoire et formalisme", 7.97, 56.89));
		addItem(new UV("MT91", "Fonctions d'une variable réelle 2", 8.34, 56.89));
		addItem(new UV("IA01", "Intelligence artificielle : apprentissage, représentation", 8, 56.89));
		addItem(new UV("MI01", "Structure d'un calculateur", 8, 56.89));
		addItem(new UV("SY01", "Elements de probabilités", 8, 56.89));
		addItem(new UV("LO21", "Programmation et conception orientées objet", 8, 56.89));
		addItem(new UV("SI07", "Médias classiques et médias numériques", 8, 56.89));
		addItem(new UV("SC22", "Sociologie cognitive, lien social et techniques", 8, 100));
		addItem(new UV("TN06", "Transmission des efforts en mécanique", 4, 67));
		addItem(new UV("AR03", "Art et technologies contemporaines", 8, 100));
		addItem(new UV("CM12", "Chimie physique minérale", 8, 100));
		addItem(new UV("BL01", "Sciences biologiques pour l'ingénieur", 8, 100));
		addItem(new UV("NF17", "Conception de bases de données", 8, 100));
		addItem(new UV("BL09", "Biophysique des systèmes biologiques", 8, 100));
		addItem(new UV("MT12", "Techniques mathématiques de l'ingénieur", 8, 100));
		addItem(new UV("MT23", "Algèbre linéaire", 8, 56.89));
		addItem(new UV("CM11", "Chimie générale", 2.7, 56.89));
		addItem(new UV("PS91", "Mécanique physique", 4.5, 56.89));
		addItem(new UV("PS04", "Thermodynamique", 5.2, 56.89));
		addItem(new UV("NF16", "Algorithmique et structures de données", 6.45, 56.89));
		addItem(new UV("HE03", "Logique : histoire et formalisme", 7.97, 56.89));
		addItem(new UV("MT91", "Fonctions d'une variable réelle 2", 8.34, 56.89));
		addItem(new UV("IA01", "Intelligence artificielle : apprentissage, représentation", 8, 56.89));
		addItem(new UV("MI01", "Structure d'un calculateur", 8, 56.89));
		addItem(new UV("SY01", "Elements de probabilités", 8, 56.89));
		addItem(new UV("LO21", "Programmation et conception orientées objet", 8, 56.89));
		addItem(new UV("SI07", "Médias classiques et médias numériques", 8, 56.89));
		addItem(new UV("SC22", "Sociologie cognitive, lien social et techniques", 8, 100));
		addItem(new UV("TN01", "Eléments de dessin technique", 6.7, 85));
		addItem(new UV("AR03", "Art et technologies contemporaines", 8, 100));
		addItem(new UV("CM12", "Chimie physique minérale", 8, 100));
		addItem(new UV("BL01", "Sciences biologiques pour l'ingénieur", 8, 100));
		addItem(new UV("NF17", "Conception de bases de données", 8, 100));
		addItem(new UV("BL09", "Biophysique des systèmes biologiques", 8, 100));
		addItem(new UV("MT12", "Techniques mathématiques de l'ingénieur", 8, 100));
		addItem(new UV("MT23", "Algèbre linéaire", 8, 56.89));
		addItem(new UV("CM11", "Chimie générale", 2.7, 56.89));
		addItem(new UV("PS91", "Mécanique physique", 4.5, 56.89));
		addItem(new UV("PS04", "Thermodynamique", 5.2, 56.89));
		addItem(new UV("NF16", "Algorithmique et structures de données", 6.45, 56.89));
		addItem(new UV("HE03", "Logique : histoire et formalisme", 7.97, 56.89));
		addItem(new UV("MT91", "Fonctions d'une variable réelle 2", 8.34, 56.89));
		addItem(new UV("IA01", "Intelligence artificielle : apprentissage, représentation", 8, 56.89));
		addItem(new UV("MI01", "Structure d'un calculateur", 8, 56.89));
		addItem(new UV("SY01", "Elements de probabilités", 8, 56.89));
		addItem(new UV("LO21", "Programmation et conception orientées objet", 8, 56.89));
		addItem(new UV("SI07", "Médias classiques et médias numériques", 8, 56.89));
		addItem(new UV("SC22", "Sociologie cognitive, lien social et techniques", 8, 100));
		addItem(new UV("TN03", "Fabrication mécanique", 4.2, 70));
		addItem(new UV("AR03", "Art et technologies contemporaines", 8, 100));
		addItem(new UV("CM12", "Chimie physique minérale", 8, 100));
		addItem(new UV("BL01", "Sciences biologiques pour l'ingénieur", 8, 100));
		addItem(new UV("NF17", "Conception de bases de données", 8, 100));
		addItem(new UV("BL09", "Biophysique des systèmes biologiques", 8, 100));
		addItem(new UV("MT12", "Techniques mathématiques de l'ingénieur", 8, 100));

		Collections.sort(UVS);

		String commentString = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor " +
				"incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
				"ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
				"voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non " +
				"proident, sunt in culpa qui officia deserunt mollit anim id est laborum";
		Calendar calendar = Calendar.getInstance();
		calendar.set(2009, Calendar.NOVEMBER, 5);
		addComment(new UVComment("amasciul", calendar, commentString, 5));
		addComment(new UVComment("tkeunebr", calendar, commentString, 5));
		addComment(new UVComment("amasciul", calendar, commentString, 5));
		addComment(new UVComment("amasciul", calendar, commentString, 5));
		addComment(new UVComment("tkeunebr", calendar, commentString, 5));
		addComment(new UVComment("tkeunebr", calendar, commentString, 5));

		String newsFeedEntryString = "You think water moves fast? You should see ice. It moves like it has a mind. " +
				"Like it knows it killed the world once and got a taste for murder. After the avalanche, it took us " +
				"a week to climb out. Now, I don't know exactly when we turned on each other, but I know that seven of" +
				" us survived the slide... and only five made it out. Now we took an oath, that I'm breaking now." +
				" We said we'd say it was the snow that killed the other two, but it wasn't. Nature is lethal but" +
				" it doesn't hold a candle to man.";
		addNewsFeedEntry(new NewsFeedEntry("amasciul", calendar, newsFeedEntryString,
				"a publié un nouveau commentaire"));
		addNewsFeedEntry(new NewsFeedEntry("tkeunebr", calendar, newsFeedEntryString,
				"a publié un nouveau commentaire"));
		addNewsFeedEntry(new NewsFeedEntry("amasciul", calendar, newsFeedEntryString,
				"a publié un nouveau commentaire"));
		addNewsFeedEntry(new NewsFeedEntry("amasciul", calendar, newsFeedEntryString,
				"a publié un nouveau commentaire"));
		addNewsFeedEntry(new NewsFeedEntry("tkeunebr", calendar, newsFeedEntryString,
				"a publié un nouveau commentaire"));
		addNewsFeedEntry(new NewsFeedEntry("tkeunebr", calendar, newsFeedEntryString,
				"a publié un nouveau commentaire"));
	}

	public static void addItem(UV item) {
		UVS.add(item);
		UV_MAP.put(item.getName(), item);
	}

	public static void addComment(UVComment comment) {
		COMMENTS.add(comment);
	}

	public static void addNewsFeedEntry(NewsFeedEntry entry) {
		NEWS_ENTRIES.add(entry);
	}

	/**
	 * A UV representing a piece of content.
	 */
	public static class UV implements Comparable<UV> {
		private String mName;
		private String mDescription;
		private double mRate;
		private double mSuccessRate;

		public UV(String name, String description, double rate, double successRate) {
			this.mName = name;
			this.mDescription = description;
			this.mRate = rate;
			this.mSuccessRate = successRate;

			//addItem(this);
		}

		@Override
		public String toString() {
			return mName;
		}

		public String getName() {
			return this.mName;
		}

		public void setName(String name) {
			this.mName = name;
		}

		public String getDescription() {
			return this.mDescription;
		}

		public void setDescription(String description) {
			this.mDescription = description;
		}

		public double getRate() {
			return this.mRate;
		}

		public void setRate(double rate) {
			this.mRate = rate;
		}

		public double getSuccessRate() {
			return mSuccessRate;
		}

		public void setSuccessRate(double successRate) {
			this.mSuccessRate = successRate;
		}

		public String getLetterCode() {
			return mName.substring(0, 2);
		}

		public String getNumberCode() {
			return mName.substring(2, 4);
		}

		public String getFormattedSuccessRate() {
			return new DecimalFormat("0.0").format(mSuccessRate) + "%";
		}

		public String getFormattedRate() {
			return new DecimalFormat("0.0").format(mRate) + "/10";
		}

		@Override
		public int compareTo(UV uv) {
			return mName.compareTo(uv.getName());
		}
	}

	public static class UVComment {
		private String mAuthor;
		private Date mDate;
		private String mComment;
		private int mGlobalRate;

		public UVComment(String author, Calendar calendar, String comment, int globalRate) {
			mAuthor = author;
			mDate = calendar.getTime();
			mComment = comment;
			mGlobalRate = globalRate;
		}

		public String getAuthor() {
			return mAuthor;
		}

		public void setAuthor(String author) {
			this.mAuthor = author;
		}

		public Date getDate() {
			return mDate;
		}

		public void setDate(Date date) {
			this.mDate = date;
		}

		public String getComment() {
			return mComment;
		}

		public void setComment(String comment) {
			this.mComment = comment;
		}

		public int getGlobalRate() {
			return mGlobalRate;
		}

		public void setGlobalRate(int globalRate) {
			this.mGlobalRate = globalRate;
		}

		public String getFormattedRate() {
			return new DecimalFormat("0").format(mGlobalRate) + "/10";
		}

		public String getFormattedDate() {
			return DateFormat.getDateInstance().format(mDate);
		}
	}

	public static class NewsFeedEntry {
		private String mAuthor;
		private Date mDate;
		private String mComment;
		private String mAction;

		public NewsFeedEntry(String author, Calendar calendar, String comment, String action) {
			mAuthor = author;
			mDate = calendar.getTime();
			mComment = comment;
			mAction = action;
		}

		public String getAuthor() {
			return mAuthor;
		}

		public String getAction() {
			return mAction;
		}

		public void setAuthor(String author) {
			this.mAuthor = author;
		}

		public Date getDate() {
			return mDate;
		}

		public void setDate(Date date) {
			this.mDate = date;
		}

		public String getComment() {
			return mComment;
		}

		public void setComment(String comment) {
			this.mComment = comment;
		}

		public String getFormattedDate() {
			return DateFormat.getDateInstance().format(mDate);
		}
	}
}
