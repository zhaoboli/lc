package main

import (
	"reflect"
	"testing"
)

func Test_findStrobogrammatic__ii(t *testing.T) {
	type args struct {
		n int
	}
	tests := []struct {
		name string
		args args
		want []string
	}{
		{
			name: "happy: n = 1",
			args: args{1},
			want: []string{"0", "1", "8"},
		}, {
			name: "happy: n = 2",
			args: args{2},
			want: []string{"11", "69", "88", "96"},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := findStrobogrammatic__ii(tt.args.n); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("findStrobogrammatic__ii() = %v, want %v", got, tt.want)
			}
		})
	}
}
