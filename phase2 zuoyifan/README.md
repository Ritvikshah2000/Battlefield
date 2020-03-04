chenges:
		1. In the cell class, I moved the isBarrier atrribute to Barrier class.
		2. change the contents atrribute to String type. If you want to check the 	 type of cell, just call cell.getContents() will.
		3. I didn't use generic since other class extends Cell.
		4. Add a CellFactory class to create different Cell, there is a demo show 	 how to create different Cell using cell factory.