package be.pxl.ja.command;

@FunctionalInterface
public interface Command<T> {
	void execute(T input);
}
