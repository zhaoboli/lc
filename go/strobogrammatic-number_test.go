package main

import "testing"

func Test_isStrobogrammatic(t *testing.T) {
	type args struct {
		num string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name:"success-0",
			args: args{"69"},
			want:true,
		},
		{
			name: "success-1",
			args: args{"121"},
			want: false,
		},
		{
			name: "success-2",
			args: args{"8"},
			want: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := isStrobogrammatic(tt.args.num); got != tt.want {
				t.Errorf("isStrobogrammatic() = %v, want %v", got, tt.want)
			}
		})
	}
}