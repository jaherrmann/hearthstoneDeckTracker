package com.hearthstone.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hearthstone.entity.Decklist;
import com.hearthstone.persistence.DecklistDao;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/manageDeck"}
)

/**
 * This class will allow the user to view all of their decks, it will also consume a web api that will
 * retrieve stats and charateristics of specific cards.
 */
public class ManageDeck extends HttpServlet {
    Logger logger = Logger.getLogger(this.getClass());
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DecklistDao dao = new DecklistDao();
        String jsonAsString = "";
        ArrayList cardNames = new ArrayList();
        ArrayList cardImages = new ArrayList();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        String searchTerm = request.getParameter("deckId");
        int deckId = Integer.parseInt(searchTerm);
        logger.info(deckId);

        List<Decklist> deck = dao.getDeckById(deckId);
        logger.info(deck);

        String jsonArrayOfCards = ow.writeValueAsString(deck);

        logger.info(jsonArrayOfCards);
        logger.info(jsonAsString);

        parseJsonObject(jsonArrayOfCards, cardNames);

        logger.info(cardNames);

        getCardImagesFromCardNameList(cardNames, cardImages);

        request.setAttribute("decks", deck);
        request.setAttribute("cards", cardImages);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/deckDisplay.jsp");
        dispatcher.forward(request, response);

    }

    private void getCardImagesFromCardNameList(ArrayList cardNames, ArrayList cardImages) {
        JSONObject cardJson;
        String cardImage = "";
        String currentCard = "";
        for(int i = 0; i < cardNames.size(); i += 1) {
            currentCard = cardNames.get(i).toString();
            logger.info(currentCard);
            try {
                HttpResponse<JsonNode> restCall = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards/" + currentCard + "")
                        .header("X-Mashape-Key", "o9Hfpar1ThmshOlE9TjuxprMZBKup1aSFi3jsnSVsL68d7Vl2z")
                        .header("Accept", "application/json")
                        .asJson();
                logger.info(restCall);

                cardJson = new JSONObject(restCall.getBody());

                cardImage = parseRestCall(cardJson);

                logger.info(cardImage);
                cardImages.add(cardImage);
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
    }

    private String parseRestCall(JSONObject cardJson) {
        String foundImg = "";
        JSONArray cardArray = cardJson.getJSONArray("array");
        JSONObject cards;
        if(cardArray.length() > 1) {
            cards = cardArray.getJSONObject(1);
        } else {
            cards = cardArray.getJSONObject(0);
        }
        foundImg = cards.getString("img");
        return foundImg;
    }

    private void parseJsonObject(String jsonArrayOfCards, ArrayList cardNames){
        String foundCard = "";
        JSONArray cardArray = new JSONArray(jsonArrayOfCards);
        logger.info(cardNames);
        JSONObject cardNamesObject = cardArray.getJSONObject(0);

        for(int i = 1; i < cardNamesObject.length(); i += 1){
            foundCard = cardNamesObject.getString("card" + i);
            cardNames.add(foundCard);
            if(i == 30){
                return;
            }
        }
    }
}
