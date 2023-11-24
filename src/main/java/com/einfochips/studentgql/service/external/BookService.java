package com.einfochips.studentgql.service.external;

import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.einfochips.studentgql.dto.Book;

@Service
public class BookService {

	private static String query = """
			query{
			    getBook(id:"%s"){
			        id
			        price
			        title
			        desc
			        pages
			        author
			    }
			}
	""";
	
	private HttpGraphQlClient graphQlClient;
	
	public BookService() {
		WebClient client = WebClient.builder().baseUrl("http://localhost:8080/graphql").build();
		graphQlClient = HttpGraphQlClient.builder(client).build();
	}

	public Book getBook(String bookId) {
		String document = String.format(query, bookId);
		
		return graphQlClient.document(document)
			.retrieve("getBook")
			.toEntity(Book.class)
			.block();
	}
}
