package vendingmachine.dto;

import java.util.Map;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.CoinQuantity;

// TODO: Output 을 Response 으로 변경
// TODO: 장황한 변수 선언과 사용을 개선할 방법이 있을지 고민 필요
public class CoinsOutputDto {
	int coin500Quantity = 0;
	int coin100Quantity = 0;
	int coin50Quantity = 0;
	int coin10Quantity = 0;

	private CoinsOutputDto(int coin500Quantity, int coin100Quantity, int coin50Quantity, int coin10Quantity) {
		this.coin500Quantity = coin500Quantity;
		this.coin100Quantity = coin100Quantity;
		this.coin50Quantity = coin50Quantity;
		this.coin10Quantity = coin10Quantity;
	}

	public static CoinsOutputDto from(Map<Coin, CoinQuantity> coins) {
		return new CoinsOutputDto(
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
}
