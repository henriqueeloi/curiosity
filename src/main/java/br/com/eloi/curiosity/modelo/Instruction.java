package br.com.eloi.curiosity.modelo;

public enum Instruction {
	LEFT {

		@Override
		public void execute(Sonda sonda) {
			sonda.moveToLeft();
		}

	},
	RIGHT {

		@Override
		public void execute(Sonda sonda) {
			sonda.moveToRight();
		}

	},
	MOVE {

		@Override
		public void execute(Sonda sonda) {
			sonda.move();
		}

	};

	public abstract void execute(Sonda sonda);


}
