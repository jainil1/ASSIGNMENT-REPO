	.arch	armv8-a
	.file	"environment.arm64-v8a.s"
	.section	.rodata..L.str.1,"aMS",@progbits,1
	.type	.L.str.1, @object
.L.str.1:
	.asciz	"com.companyname.firstxam"
	.size	.L.str.1, 25
	.section	.data.application_config,"aw",@progbits
	.type	application_config, @object
	.p2align	3
	.global	application_config
application_config:
	/* uses_mono_llvm */
	.byte	0
	/* uses_mono_aot */
	.byte	0
	/* uses_assembly_preload */
	.byte	1
	/* is_a_bundled_app */
	.byte	0
	/* environment_variable_count */
	.word	12
	/* system_property_count */
	.word	0
	.zero	4
	/* android_package_name */
	.xword	.L.str.1
	.size	application_config, 24
	.section	.rodata..L.str.2,"aMS",@progbits,1
	.type	.L.str.2, @object
.L.str.2:
	.asciz	"0"
	.size	.L.str.2, 2
	.section	.data.mono_aot_mode_name,"aw",@progbits
	.global	mono_aot_mode_name
mono_aot_mode_name:
	.xword	.L.str.2
	.section	.rodata..L.str.3,"aMS",@progbits,1
	.type	.L.str.3, @object
.L.str.3:
	.asciz	"MONO_GC_PARAMS"
	.size	.L.str.3, 15
	.section	.rodata..L.str.4,"aMS",@progbits,1
	.type	.L.str.4, @object
.L.str.4:
	.asciz	"major=marksweep-conc"
	.size	.L.str.4, 21
	.section	.rodata..L.str.5,"aMS",@progbits,1
	.type	.L.str.5, @object
.L.str.5:
	.asciz	"MONO_LOG_LEVEL"
	.size	.L.str.5, 15
	.section	.rodata..L.str.6,"aMS",@progbits,1
	.type	.L.str.6, @object
.L.str.6:
	.asciz	"info"
	.size	.L.str.6, 5
	.section	.rodata..L.str.7,"aMS",@progbits,1
	.type	.L.str.7, @object
.L.str.7:
	.asciz	"XAMARIN_BUILD_ID"
	.size	.L.str.7, 17
	.section	.rodata..L.str.8,"aMS",@progbits,1
	.type	.L.str.8, @object
.L.str.8:
	.asciz	"ed46a044-27d4-42c9-b3ac-bc9a65357380"
	.size	.L.str.8, 37
	.section	.rodata..L.str.9,"aMS",@progbits,1
	.type	.L.str.9, @object
.L.str.9:
	.asciz	"XA_HTTP_CLIENT_HANDLER_TYPE"
	.size	.L.str.9, 28
	.section	.rodata..L.str.10,"aMS",@progbits,1
	.type	.L.str.10, @object
.L.str.10:
	.asciz	"Xamarin.Android.Net.AndroidClientHandler"
	.size	.L.str.10, 41
	.section	.rodata..L.str.11,"aMS",@progbits,1
	.type	.L.str.11, @object
.L.str.11:
	.asciz	"XA_TLS_PROVIDER"
	.size	.L.str.11, 16
	.section	.rodata..L.str.12,"aMS",@progbits,1
	.type	.L.str.12, @object
.L.str.12:
	.asciz	"btls"
	.size	.L.str.12, 5
	.section	.rodata..L.str.13,"aMS",@progbits,1
	.type	.L.str.13, @object
.L.str.13:
	.asciz	"__XA_PACKAGE_NAMING_POLICY__"
	.size	.L.str.13, 29
	.section	.rodata..L.str.14,"aMS",@progbits,1
	.type	.L.str.14, @object
.L.str.14:
	.asciz	"LowercaseCrc64"
	.size	.L.str.14, 15
	.section	.data.app_environment_variables,"aw",@progbits
	.type	app_environment_variables, @object
	.p2align	3
	.global	app_environment_variables
app_environment_variables:
	.xword	.L.str.3
	.xword	.L.str.4
	.xword	.L.str.5
	.xword	.L.str.6
	.xword	.L.str.7
	.xword	.L.str.8
	.xword	.L.str.9
	.xword	.L.str.10
	.xword	.L.str.11
	.xword	.L.str.12
	.xword	.L.str.13
	.xword	.L.str.14
	.size	app_environment_variables, 96
	.section	.data.app_system_properties,"aw",@progbits
	.type	app_system_properties, @object
	.p2align	3
	.global	app_system_properties
app_system_properties:
	.size	app_system_properties, 0
