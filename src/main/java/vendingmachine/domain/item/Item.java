package vendingmachine.domain.item;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.userbalance.UserBalance;

public class Item {
	private static final String SPLIT_DELIMITER = ",";
	private static final String OPEN_BRACKET = "[";
	private static final String CLOSE_BRACKET = "]";
	private static final String BLANK_CHAR = "";
	private static final String TO_STRING_FORMAT = "{ItemName=%s, ItemPrice=%s, ItemQuantity=%s}";

	private final ItemName name;
	private final ItemPrice price;
	private final ItemQuantity quantity;

	private Item(ItemName name, ItemPrice price, ItemQuantity quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public static Item of(String name, int price, int quantity) {
		ItemName itemName = ItemName.from(name);
		ItemPrice itemPrice = ItemPrice.from(price);
		ItemQuantity itemQuantity = ItemQuantity.from(quantity);

		return new Item(itemName, itemPrice, itemQuantity);
	}

	private static String removeBracket(String input) {
		return input.replace(OPEN_BRACKET, BLANK_CHAR).replace(CLOSE_BRACKET, BLANK_CHAR);
	}

	private static List<String> parseInput(String input) {
		return Arrays.stream(input.split(SPLIT_DELIMITER))
			.collect(Collectors.toList());
	}

	public ItemName getItemName() {
		return this.name;
	}

	public ItemPrice getItemPrice() {
		return this.price;
	}

	public boolean isSoldOut() {
		return this.quantity.toInt() <= 0;
	}

	public boolean isEnoughBalance(UserBalance userBalance) {
		return this.price.toInt() <= userBalance.toInt();
	}

	public Item buy() {
		ItemQuantity subtractedQuantity = this.quantity.subtract();
		return new Item(this.name, this.price, subtractedQuantity);
	}

	@Override
	public String toString() {
		return String.format(TO_STRING_FORMAT, this.name.toString(), this.price.toString(), this.quantity.toString());
	}
}
