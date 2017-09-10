package com.alexzm1.topup.auth.transform;

/**
 * 
 * <b>Transformer</b>
 *
 * Transformer one object type <b>T</b> to an object <b>S</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 * @param <T>
 *            Input object
 * @param <S>
 *            Output object
 */
public interface Transformer<T, S> {

	/**
	 * Receives an object <b>T</b> and returns an object <b>S</b>
	 * 
	 * @param source
	 *            Object <T>
	 * @return Transformed object <b>S</b>
	 */
	S transform(T source);

}
