package vendingmachine.dto;

import java.util.Map;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.CoinQuantity;

public class CoinsDto {
	int coin500Quantity;
	int coin100Quantity;
	int coin50Quantity;
	int coin10Quantity;

	private CoinsDto(int coin500Quantity, int coin100Quantity, int coin50Quantity, int coin10Quantity) {
		this.coin500Quantity = coin500Quantity;
		this.coin100Quantity = coin100Quantity;
		this.coin50Quantity = coin50Quantity;
		this.coin10Quantity = coin10Quantity;
	}

	public static CoinsDto from(Map<Coin, CoinQuantity> coins) {
		return new CoinsDto(
			coins.get(Coin.COIN_500).toInt(),
			coins.get(Coin.COIN_100).toInt(),
			coins.get(Coin.COIN_50).toInt(),
			coins.get(Coin.COIN_10).toInt()
		);
	}

	public int getCoin500Quantity() {
		return this.coin500Quantity;
	}

	public int getCoin100Quantity() {
		return this.coin100Quantity;
	}

	public int getCoin50Quantity() {
		return this.coin50Quantity;
	}

	public int getCoin10Quantity() {
		return this.coin10Quantity;
	}

	public int getAllCoinQuantity() {
		return coin500Quantity + coin100Quantity + coin50Quantity + coin10Quantity;
	}
}
