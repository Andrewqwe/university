#include "stdafx.h"
#include <windows.h>
#include <stdio.h>
#include <iphlpapi.h>
#include <Psapi.h>
#include "MyUtility.h"


JNIEXPORT jint JNICALL Java_com_andrzej_MyJNIUtility_getProcessWorkingSet(JNIEnv *env, jobject obj)
{
	PROCESS_MEMORY_COUNTERS  pmc;

	pmc.cb = sizeof(pmc);

	if (!GetProcessMemoryInfo(GetCurrentProcess(), &pmc, sizeof(pmc)))
		return NULL;           // (must be running on Win9x)

	return pmc.WorkingSetSize;
}

JNIEXPORT jint JNICALL Java_com_andrzej_MyJNIUtility_getProcessVMSize(JNIEnv *env, jobject obj)
{
	PROCESS_MEMORY_COUNTERS  pmc;

	pmc.cb = sizeof(pmc);

	if (!GetProcessMemoryInfo(GetCurrentProcess(), &pmc, sizeof(pmc)))
		return NULL;           // (must be running on Win9x)

	return pmc.PagefileUsage;
}
