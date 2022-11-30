The sm_sldds-2.0.jar is built from sm_sldds-1.0.jar, the only change is that we replaced velocity-1.3.jar with velocity-core-2.3.jar due to the security issue 'CVE-2020-13936' introduced by velocity-1.3.jar.

At this point of time, we can't find a higher version of sm_sldds(this lib is hard to access) that without security issue 'CVE-2020-13936'.
If in the future there comes a higher version of sm_sldds that resolves 'CVE-2020-13936', we can get it back to maven dependency and do the upgrade.

For more context, see https://jira.tools.sap/browse/CXEC-9860.
