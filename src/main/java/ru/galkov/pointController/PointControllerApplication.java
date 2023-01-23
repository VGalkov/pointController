package ru.galkov.pointController;

import ru.galkov.pointController.field.FieldApp;
import ru.galkov.pointController.queue.QueueApp;
import ru.galkov.pointController.server.ServerApp;
import ru.galkov.pointController.visualiser.VisualiserApp;

public class PointControllerApplication {

	public static void main(String[] args) {
		/*
		тут всё будет довбольно неряшливо,
		поскольку фактически это запуск нескольких разных приложений, которые долны работать
		друг с другом через очереди сообщений, кафка тут заменена простенькой проектной чтобы не разворачивать
		мергадеплой для демопроекта.
		*/
		//порядок запуска пока имеет значение из-за GraphicsEnvironment.getLocalGraphicsEnvironment().isHeadlessInstance
		// клиент, отображение
		VisualiserApp.main(args);

		// сервер-очередь сообщений между процессами.
		QueueApp.main(args);

		// управляющий стратегиями сервер
		ServerApp.main(args);

		// список "дронов"
		FieldApp.main(args);

	}

}
