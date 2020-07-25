package assignment2;

public class Library {
	public static void main(String[] args) {
		
	
	Bookclass b1 = new Reference() {
		public String gettitle()  {
				return "Baba";
			}

			public String getisbn() {
				return "123-231";
			}
		
		};
	Bookclass b2 = new Text() {
			public String gettitle()  {
					return "Harry";
				}

				public String getisbn() {
					return "323-232";
				}
			
			};
	Bookclass b3 = new Fiction() {
				public String gettitle()  {
						return "Batman";
					}

					public String getisbn() {
						return "123-456";
					}
				
				};
				Bookclass.details(b1);
				Bookclass.details(b2);
				Bookclass.details(b3);
			
		}
	

}

