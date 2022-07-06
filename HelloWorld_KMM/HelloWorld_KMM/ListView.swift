//
//  ListView.swift
//  HelloWorld_KMM
//
//  Created by Vitalii on 05.07.2022.
//

import SwiftUI

struct ListView: View {
    @EnvironmentObject var viewModel: ListViewModel
    
    var body: some View {
        NavigationView {
            
            List {
                ForEach(viewModel.placeholders) { placeholder in
                    HStack {
                        Text("\(placeholder.id)")
                        Text(placeholder.title)
                            .lineLimit(1)
                            .frame(maxWidth: .infinity,
                                   alignment: .trailing)
                    }
                }
            }
            .navigationBarTitle("", displayMode: .inline)
            .navigationBarHidden(true)
            
        }
        .navigationViewStyle(.stack)
        
        .onAppear {
            viewModel.startMonitoring()
        }.onDisappear {
            viewModel.stopMonitoring()
        }
    }
}

struct ListView_Previews: PreviewProvider {
    static var previews: some View {
        ListView().environmentObject(ListViewModel_Preview())
    }
}
