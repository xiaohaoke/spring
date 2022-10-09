package aware;

import org.springframework.beans.factory.BeanNameAware;

public class Teacher implements BeanNameAware {

	private String beanName;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the name of the bean in the bean factory that created this bean.
	 * <p>Invoked after population of normal bean properties but before an
	 * init callback such as {@link InitializingBean#afterPropertiesSet()}
	 * or a custom init-method.
	 *
	 * @param name the name of the bean in the factory.
	 *             Note that this name is the actual bean name used in the factory, which may
	 *             differ from the originally specified name: in particular for inner bean
	 *             names, the actual bean name might have been made unique through appending
	 *             "#..." suffixes. Use the {@link BeanFactoryUtils#originalBeanName(String)}
	 *             method to extract the original bean name (without suffix), if desired.
	 */
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}


	public String getBeanName() {
		return beanName;
	}
}
