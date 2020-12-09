package cl.uchile.dcc.cc3002.king.controller;

import cl.uchile.dcc.cc3002.king.model.Player;
import cl.uchile.dcc.cc3002.king.model.cards.ICard;

import java.util.LinkedList;

public class GameController {
  private final Player playerA;
  private final Player playerB;
  private final LinkedList<Player> players = new LinkedList<>();
  // public interface IEventHandler extends PropertyChangeListener
  private final IEventHandler cardPlayedHandler = new CardPlayedHandler(this);

  public GameController() {
    /*
    Constructor de GameController
      Genera dos Player (A y B), los agrega a la lista enlazada player
    */
    playerA = new Player("Player A", 8000);
    playerB = new Player("Player B", 8000);
    players.add(playerA);
    players.add(playerB);
    /*
    Se configura que cardPlayedHandler (PropertyChangeListener) de esta clase este atento al método playcard() (cardPlayedEvent.firePropertyChange) de los objetos player A y B, mediante
    sus cardPlayedEvent (PropertyChangeSupport). Cuando ocurra un cambio en la propiedad, se ejecutará el método propertyChange de la clase CardPlayedHandler.
    */
    playerA.addListener(cardPlayedHandler);
    playerB.addListener(cardPlayedHandler);
  }

  public void endTurn() {
    /*
    remueve al primer player de players y lo agrega al final.
    */
    /*
    The Java.util.LinkedList.removeFirst() method is used to remove the first element from a linked list. This function also returns the first element after removing it.
    */
    var tmp = players.removeFirst();
    players.add(tmp);
  }

  public void onCardPlayed(ICard card) {
    System.out.println(card.getName() + " was played.");
  }
}
