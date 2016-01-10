package atg.targeting;

import atg.core.util.StringUtils;
import atg.naming.NameResolver;
import atg.repository.RepositoryItem;
import atg.repository.xml.GetException;
import atg.servlet.ServletUtil;

public class WebServicesTargetingServices extends TargetingServices {

	public WebServicesTargetingServices() {
		super();
	}

	public RepositoryItem[] executeRepositoryTargeterItems(String targeterPath, String strToIgnore) throws TargetingException, GetException {
		if (!StringUtils.isEmpty(targeterPath) && !targeterPath.equalsIgnoreCase(strToIgnore)) {
			return executeRepositoryTargeterItems(targeterPath, 0, -1, null);
		} else {
			return null;
		}
		
	}
	
	public RepositoryItem[] executeRepositoryTargeterItems(String targeterPath) throws TargetingException {
		try {
			return executeRepositoryTargeterItems(targeterPath, 0, -1, null);
		} catch (GetException e) {
			throw new TargetingException("GetException thrown in WebServicesTargetingServices.executeRepositoryTargeterItems", e);
		}
	}
	
	public RepositoryItem[] executeRepositoryTargeterItems(String targeterPath, int startingIndex, int endingIndex, String mappingFile)
			throws TargetingException, GetException {
		if (StringUtils.isEmpty(targeterPath)) {
			return null;
		}

		NameResolver resolver = ServletUtil.getCurrentRequest();
		if (resolver == null) {
			resolver = this;
		}

		if (this.mTargetingSourceMap != null) {
			resolver = this.mTargetingSourceMap.getNameResolver(resolver);
		}
		Object component = resolver.resolveName(targeterPath);
		if (component == null) {
			Object[] args = { targeterPath };
			if (isLoggingError()) {
				logError("No component resolved from " + targeterPath);
			}
			return null;
		}

		if (!(component instanceof Targeter)) {
			Object[] args = { targeterPath, Targeter.class.getName() };
			if (isLoggingError()) {
				logError("component resolved is not a Targeter");
			}
			return null;
		}

		Targeter targeter = (Targeter) component;

		Object[] results = targeter.target(resolver, startingIndex, endingIndex);
		if ((results == null) || (results.length == 0)) {
			return null;
		}
		RepositoryItem[] itemResults = new RepositoryItem[results.length];
		for (int i = 0; i < itemResults.length; ++i) {
			Object result = results[i];
			if (!(result instanceof RepositoryItem)) {
				Object[] args = { targeterPath, RepositoryItem.class.getName(), result.getClass().getName() };

				if (isLoggingError()) {
					logError("one of the results returned is NOT a RepositoryItem");
				}
				return null;
			}
			itemResults[i] = ((RepositoryItem) result);
		}
		return itemResults;
	}

}
