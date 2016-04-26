package aves.deliveryapp.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class GsonConvertor {

	public List parentClasses = new ArrayList();

	public <T, E> T convertObjectToJson(T t) {
		try {
			if (t != null && t.getClass() != null
					&& t.getClass().getDeclaredFields() != null) {
				parentClasses.add(t);
				for (Field field : t.getClass().getDeclaredFields()) {
					if (field != null
							&& field.getType() != null
							&& (field.getType().equals(List.class) || field
									.getType().equals(ArrayList.class))) {
						Method method = null;
						try {
							method = t.getClass().getMethod(
									"get"
											+ field.getName().substring(0, 1)
													.toUpperCase()
											+ field.getName().substring(1));
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
						} catch (SecurityException e1) {
							e1.printStackTrace();
						} catch (NoSuchMethodException e1) {
							e1.printStackTrace();
						}
						if (method != null) {
							List<E> value1 = null;
							try {
								value1 = (List<E>) method.invoke(t);
							} catch (IllegalArgumentException e1) {
								e1.printStackTrace();
							} catch (SecurityException e1) {
								e1.printStackTrace();
							}
							if (value1 != null) {
								for (E e : value1) {
									if (e != null
											&& e.getClass() != null
											&& e.getClass().getDeclaredFields() != null) {
										parentClasses.add(e);
										for (Field field1 : e.getClass()
												.getDeclaredFields()) {
											if (field1 != null
													&& field1.getType() != null
													&& field1.getType()
															.toString()
															.contains("class")
													&& !field1.getType()
															.toString()
															.contains("java")) {
												method = null;
												for (int incrm = 0; incrm < parentClasses
														.size(); incrm++) {
													if (parentClasses
															.get(incrm) != null
															&& field1
																	.getType()
																	.equals(parentClasses
																			.get(incrm)
																			.getClass())) {
														try {
															method = e
																	.getClass()
																	.getMethod(
																			"set"
																					+ field1.getName()
																							.substring(
																									0,
																									1)
																							.toUpperCase()
																					+ field1.getName()
																							.substring(
																									1),
																			new Class[] { parentClasses
																					.get(incrm)
																					.getClass() });
														} catch (IllegalArgumentException e1) {
															e1.printStackTrace();
														} catch (SecurityException e1) {
															e1.printStackTrace();
														} catch (NoSuchMethodException e1) {
															e1.printStackTrace();
														}
														break;
													}
												}
												if (method != null) {
													try {
														method.invoke(
																e,
																new Object[] { null });
													} catch (IllegalArgumentException e1) {
														e1.printStackTrace();
													} catch (SecurityException e1) {
														e1.printStackTrace();
													}
												}
											}
										}
										if (e != null) {
											convertObjectToJson(e);
										}
									}
								}
							}
						}
					} else if (field != null && field.getType() != null
							&& field.getType().toString().contains("class")
							&& !field.getType().toString().contains("java")) {
						Method method = null;
						try {
							method = t.getClass().getMethod(
									"get"
											+ field.getName().substring(0, 1)
													.toUpperCase()
											+ field.getName().substring(1));
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
						} catch (SecurityException e1) {
							e1.printStackTrace();
						} catch (NoSuchMethodException e1) {
							e1.printStackTrace();
						}
						if (method != null) {
							Object value1 = null;
							try {
								value1 = method.invoke(t);
							} catch (IllegalArgumentException e1) {
								e1.printStackTrace();
							} catch (SecurityException e1) {
								e1.printStackTrace();
							}
							if (value1 != null) {
								convertObjectToJson(value1);
							}
						}
					}
				}
			}
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
		return t;
	}

	public <T, E> T convertJsonToObject(T t) {
		try {
			if (t != null && t.getClass() != null
					&& t.getClass().getDeclaredFields() != null) {
				parentClasses.add(t);
				for (Field field : t.getClass().getDeclaredFields()) {
					if (field != null
							&& field.getType() != null
							&& (field.getType().equals(List.class) || field
									.getType().equals(ArrayList.class))) {
						Method method = null;
						try {
							method = t.getClass().getMethod(
									"get"
											+ field.getName().substring(0, 1)
													.toUpperCase()
											+ field.getName().substring(1));
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
						} catch (SecurityException e1) {
							e1.printStackTrace();
						} catch (NoSuchMethodException e1) {
							e1.printStackTrace();
						}
						if (method != null) {
							List<E> value1 = null;
							try {
								value1 = (List<E>) method.invoke(t);
							} catch (IllegalArgumentException e1) {
								e1.printStackTrace();
							} catch (SecurityException e1) {
								e1.printStackTrace();
							}
							if (value1 != null) {
								for (E e : value1) {
									if (e != null
											&& e.getClass() != null
											&& e.getClass().getDeclaredFields() != null) {
										parentClasses.add(e);
										for (Field field1 : e.getClass()
												.getDeclaredFields()) {
											if (field1 != null
													&& field1.getType() != null
													&& field1.getType()
															.toString()
															.contains("class")
													&& !field1.getType()
															.toString()
															.contains("java")) {
												method = null;
												for (int incrm = 0; incrm < parentClasses
														.size(); incrm++) {
													if (parentClasses
															.get(incrm) != null
															&& field1
																	.getType()
																	.equals(parentClasses
																			.get(incrm)
																			.getClass())) {
														method = null;
														try {
															method = e
																	.getClass()
																	.getMethod(
																			"set"
																					+ field1.getName()
																							.substring(
																									0,
																									1)
																							.toUpperCase()
																					+ field1.getName()
																							.substring(
																									1),
																			new Class[] { parentClasses
																					.get(incrm)
																					.getClass() });
														} catch (IllegalArgumentException e1) {
															e1.printStackTrace();
														} catch (SecurityException e1) {
															e1.printStackTrace();
														} catch (NoSuchMethodException e1) {
															e1.printStackTrace();
														}
														if (method != null) {
															try {
																method.invoke(
																		e,
																		new Object[] { parentClasses
																				.get(incrm) });
															} catch (IllegalArgumentException e1) {
																e1.printStackTrace();
															} catch (SecurityException e1) {
																e1.printStackTrace();
															}
														}
														break;
													}
												}
											}
										}
										if (e != null) {
											boolean status = true;
											for (int incrm = 0; incrm < parentClasses
													.size(); incrm++) {
												if (parentClasses.get(incrm) != null
														&& e.getClass()
																.equals(parentClasses
																		.get(incrm)
																		.getClass())) {
													status = false;
													break;
												}
											}
											if (status) {
												convertJsonToObject(e);
											}
										}
									}
								}
							}
						}
					} else if (field != null && field.getType() != null
							&& field.getType().toString().contains("class")
							&& !field.getType().toString().contains("java")) {
						Method method = null;
						try {
							method = t.getClass().getMethod(
									"get"
											+ field.getName().substring(0, 1)
													.toUpperCase()
											+ field.getName().substring(1));
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
						} catch (SecurityException e1) {
							e1.printStackTrace();
						} catch (NoSuchMethodException e1) {
							e1.printStackTrace();
						}
						if (method != null) {
							Object value1 = null;
							try {
								value1 = method.invoke(t);
							} catch (IllegalArgumentException e1) {
								e1.printStackTrace();
							} catch (SecurityException e1) {
								e1.printStackTrace();
							}
							if (value1 != null) {
								boolean status = true;
								for (int incrm = 0; incrm < parentClasses
										.size(); incrm++) {
									if (parentClasses.get(incrm) != null
											&& value1.getClass().equals(
													parentClasses.get(incrm)
															.getClass())) {
										status = false;
										break;
									}
								}
								if (status) {
									convertJsonToObject(value1);
								}
							}
						}
					}
				}
			}
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
		return t;
	}

	public <T, E> List<T> convertObjectToJson(List<T> r) {
		if (r != null) {
			for (T t : r) {
				parentClasses = new ArrayList();
				convertObjectToJson(t);
			}
		}
		return r;
	}

	public <T, E> List<T> convertJsonToObject(List<T> r) {
		if (r != null) {
			for (T t : r) {
				parentClasses = new ArrayList();
				convertJsonToObject(t);
			}
		}
		return r;
	}
}
